package com.xr.springboot;

import com.xr.springboot.pojo.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    /**
     * 加密密码
     */
    public User encryptPassword(User user) {
        //设置随机salt
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        //密码明文+随机salt=密码密文
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                //credentialsSalt=username+salt
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();
        //设置密码密文
        user.setPassword(newPassword);

        return user;
    }

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        User user1 = encryptPassword(user);
        System.out.println(user1);
    }


}
