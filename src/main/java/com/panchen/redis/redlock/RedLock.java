package com.panchen.redis.redlock;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedLock {

	private static String redisAddressA = "redis://127.0.0.1:6378";
	private static String redisAddressB = "redis://127.0.0.1:6379";
	private volatile Boolean isLock = false;

	private RedissonRedLock init() {
		Config configA = new Config();
		configA.useSingleServer().setAddress(redisAddressA);
		RedissonClient redissonClientA = Redisson.create(configA);

		Config configB = new Config();
		configB.useSingleServer().setAddress(redisAddressB);
		RedissonClient redissonClientB = Redisson.create(configB);

		String lockName = "TEST_KEY";

		RLock lockA = redissonClientA.getLock(lockName);
		RLock lockB = redissonClientB.getLock(lockName);

		return new RedissonRedLock(lockA, lockB);

	}

	public static void main(String[] args) {
		RedLock redLock = new RedLock();
		RedissonRedLock redissonRedLock = redLock.init();
		redLock.lock(redissonRedLock);
	}

	private void lock(RedissonRedLock redissonRedLock) {
		try {
			if (!isLock) {
				isLock = redissonRedLock.tryLock(1000, 10000, TimeUnit.MILLISECONDS);
				if (isLock) {
					// todo
				}
			}
		} catch (InterruptedException e) {
		} finally {
			redissonRedLock.unlock();
			isLock = false;
		}
	}

}
