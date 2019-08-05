package cn.jgayb.security

import cn.jgayb.security.cn.jgayb.security.UserRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.Assert

@RunWith(SpringRunner::class)
@SpringBootTest
class SecurityApplicationTests {
    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    @Transactional
    fun contextLoads() {
        val userOpt = userRepository.findById(1)

        Assert.isTrue(userOpt.isPresent, "")
        Assert.notNull(userOpt.get().role, "")

        println(userOpt.get().toString())

    }

}
