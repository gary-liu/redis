package com.mimi.redis.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class JedisTest3 {
    public static void main(String[] args) {
        Set<HostAndPort> nodeList = new HashSet<>();
        nodeList.add(new HostAndPort("172.18.92.244", 7000));
        nodeList.add(new HostAndPort("172.18.92.244", 7001));
        nodeList.add(new HostAndPort("172.18.92.244", 7002));
        nodeList.add(new HostAndPort("172.18.92.244", 7003));
        nodeList.add(new HostAndPort("172.18.92.244", 7004));
        nodeList.add(new HostAndPort("172.18.92.244", 7005));

        //jedis连接池配制
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大空闲连接数
        jedisPoolConfig.setMaxIdle(200);
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMinIdle(100);
        jedisPoolConfig.setMaxWaitMillis(3000);
        jedisPoolConfig.setTestOnBorrow(false);
        JedisCluster jedisCluster = new JedisCluster(nodeList, jedisPoolConfig);
        while (true) {

        }
    }
}
