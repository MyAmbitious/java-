package com.alex.hutool.ssh;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;

public class sshDemo {
    public static void main(String[] args) {
        //新建会话，此会话用于ssh连接到跳板机（堡垒机），此处为10.1.1.1:22
        Session session = JschUtil.getSession("hdp-07", 22, "root", "hadoop");
        // 将堡垒机保护的内网8080端口映射到localhost，我们就可以通过访问http://localhost:8080/访问内网服务了
        JschUtil.bindPort(session, "hdp-07", 8080, 8080);
    }
}
