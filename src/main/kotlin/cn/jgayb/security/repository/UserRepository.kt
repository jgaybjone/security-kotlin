package cn.jgayb.security.repository

import cn.jgayb.security.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Classname UserRepository
 * Description
 * Date 2019-08-05 13:17
 * Created by Wang jun gang
 */
interface UserRepository : JpaRepository<User, Int> {
}