package com.mimi.redis.jedis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.params.SetParams;

import java.util.List;

public class JedisTest {

    Jedis jedis ;

    @Before
    public void init() {
        jedis = new Jedis("47.107.143.93", 7000);


    }

    @Test
    public void test() {
        jedis.set("test", "test");
        System.out.println(jedis.get("test"));
        jedis.set("test", "test2");
        System.out.println(jedis.get("test"));
        jedis.append("test", "test3");
        System.out.println(jedis.get("test"));

    }

    @Test
    public void test2() {
        SetParams setParams = new SetParams();
        setParams.ex(100);
        setParams.nx();
    }


    @Test
    public void test3() {
        Scan("0");

    }

    public void Scan(String cursor) {
        String key = "k*";
        ScanParams scanParams = new ScanParams();
        scanParams.match(key);
        scanParams.count(2);
        ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
        cursor = scanResult.getCursor();
        System.out.println("游标为：" + cursor);
        List<String> list = scanResult.getResult();
        for (int i = 0; i < list.size(); i++) {
            String mapentry = list.get(i);
            System.out.println("查询出key:" + mapentry);
        }

        System.out.println("++++++++++++++++++++++++++++++++");
        if (!"0".equals(cursor)) {
            this.Scan(cursor);

        }


    }


}
