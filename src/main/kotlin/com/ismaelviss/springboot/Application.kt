package com.ismaelviss.springboot

import com.ismaelviss.springboot.bean.MyBean
import com.ismaelviss.springboot.bean.MyBeanWithOperation
import com.ismaelviss.springboot.bean.MyBeanWithProperties
import com.ismaelviss.springboot.component.ComponentDependency
import com.ismaelviss.springboot.entity.User
import com.ismaelviss.springboot.pojo.UserPojo
import com.ismaelviss.springboot.repository.UserRepository
import com.ismaelviss.springboot.service.UserService
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.domain.Sort
import java.time.LocalDate

/**
 * el qualifier te permite especificar cual implementación de una interfaz se va a utilizar, esto es cuando tengas dos implementaciones de una misma interfaz.
 */
@SpringBootApplication
class Application(
    @Qualifier("componentTwoImplement") private var componentDependency: ComponentDependency,
    private var myBean: MyBean,
    private val myBeanWithOperation: MyBeanWithOperation,
    private var myBeanWithProperties: MyBeanWithProperties,
    private var userPojo: UserPojo,
    private var userRepository: UserRepository,
    private val userService: UserService
)
    : CommandLineRunner {

    private val log: Log = LogFactory.getLog(Application::class.java)

    override fun run(vararg args: String?) {
        //ejemplosAnteriores()
        saveUserInDataBase()

        getInformationJpqlFromUser()

        saveWithErrorTransactional()
    }

    private fun getInformationJpqlFromUser() {
        log.info("usuario por email " + userRepository.findUserByEmail("esalvati@algo.com").orElseThrow { Exception("no existe") })
        log.info("usuarios por contenido en el name:")
        userRepository.findUsersByNameAndOrderBy("e", Sort.by("name").descending())
            .stream()
            .forEach {
                log.info(it.toString())
            }

        log.info("usuario por nombre " + userRepository.findUserByName("Elvis").orElseThrow { Exception("no existe") })
        log.info("usuario por nombre like")
        userRepository.findUsersByNameLike("%e%")
            .stream()
            .forEach(log::info)

        log.info("usuario por email o nombre " + userRepository.findByEmailOrName("esalvati@algo.com", null).orElseThrow { Exception("no existe") })

        userRepository.findUsersByBirtDateBetween(LocalDate.of(1995,1,1), LocalDate.of(2002,1,1))
            .stream()
            .forEach(log::info)

        userRepository.findUsersByNameLikeOrderById("%e%")
            .stream()
            .forEach(log::info)

        userRepository.findUsersByNameContainingOrderById("e")
            .stream()
            .forEach(log::info)

        log.info("usuario con named parameters " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(1993, 4, 18), "mgomez@algo.com").orElseThrow {
            Exception("no existe")
        })
    }

    private fun saveWithErrorTransactional() {
        val test1 = User("test1", "test1@algo.com", LocalDate.of(1993, 8, 31))
        val test2 = User("test2", "test1@algo.com", LocalDate.of(1993, 8, 31))
        val test3 = User("test3", "test3@algo.com", LocalDate.of(1993, 8, 31))

        val users = arrayListOf<User>(test1, test2, test3)

        try {
            userService.saveTransactional(users)
        }catch (ex: Exception) { log.error(ex) }

        userService.getAllUsers()
            .stream()
            .forEach(log::info)
    }

    private fun saveUserInDataBase() {
        val user = User("Elvis", "esalvati@algo.com", LocalDate.of(1993, 8, 31))
        val user1 = User("Madeline", "mgomez@algo.com", LocalDate.of(1993, 4, 18))
        val user2 = User("Kevin", "ksalvati@algo.com", LocalDate.of(1995, 1, 12))
        val user3 = User("Anthony", "asalvati@algo.com", LocalDate.of(2001, 11, 14))
        val user4 = User("Jose", "jsalvati@algo.com", LocalDate.of(1971, 1, 10))

        val listUsers = listOf<User>(user,  user1, user2, user3, user4)
        //userRepository.saveAll(listUsers)
        listUsers.stream().forEach(userRepository::save)
    }

    private fun ejemplosAnteriores() {
        componentDependency.greetMethod()
        myBean.print()
        myBeanWithOperation.printWithDependency()
        println(myBeanWithProperties.function())
        println("${userPojo.age} ${userPojo.email} ${userPojo.password}")
        log.error("esto es un error")
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
