package com.bmarques.springredis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisConnectionException;
import io.lettuce.core.api.StatefulRedisConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//public class RedisConnection {
//
//  private static final Logger LOGGER = LoggerFactory.getLogger(RedisConnection.class);
//
//  private final String host;
//  private final String port;
//  private final Integer retryCount;
//
//  RedisClient redisClient;
//  StatefulRedisConnection<String, String> connection;
//
//  /**
//   * Create a RedisConnection to the given host, port. Use 5 as the default connect attempts.
//   *
//   * @param host Redis host
//   * @param port Redis port
//   */
//  public RedisConnection(String host, String port) {
//    this(host, port, 5);
//  }
//
//  /**
//   * Create a RedisConnection to the given host, port and connect attempts.
//   *
//   * @param host Redis host
//   * @param port Redis port
//   * @param retries number of attempts to connect
//   */
//  public RedisConnection(String host, String port, int retries) {
//    this.host = host;
//    this.port = port;
//    this.retryCount = retries;
//  }
//
//  /**
//   * Open connection to redis specified by redisUri. Tries to use the environment variable
//   * "APPSERVER_INSTANCE" to set as the name for this connection for auditing purposes. If
//   * environment variable is not found, tries to use the host name of the current machine.
//   */
//  public void start() {
//    String application = System.getProperty("instanceName");
//    if (application == null || application.length() == 0) {
//      try {
//        application = InetAddress.getLocalHost().getHostName();
//      } catch (final UnknownHostException e) {
//        application = "unknownJavaApplication";
//        LOGGER.debug("Cannot determine app name, using default: {}", application);
//      }
//    }
//    start(application);
//  }
//
//  /**
//   * Open connection to redis specified by redis_uri.
//   *
//   * @param connectionName Name to apply to this connection for auditing purposes
//   */
//  public void start(final String connectionName) {
//    if (connection != null && connection.isOpen()) {
//      return;
//    }
//    if (redisClient == null) {
//      String redisUri = createRedisUri();
//      LOGGER.info("Initializing redis client with URI: {}.", redisUri);
//      redisClient = RedisClient.create(redisUri);
//    }
//    if (connection == null) {
//      LOGGER.info("Connection not found, initializing.");
//      connection = connectClientWithRetry(retryCount);
//    }
//    if (!connection.isOpen()) {
//      LOGGER.info("Connection not open, reconnecting.");
//      connection = connectClientWithRetry(retryCount);
//    }
//    get().async().clientSetname(connectionName);
//  }
//
//  /**
//   * Gets connection to Redis.
//   *
//   * <p>From <a href="https://github.com/mp911de/lettuce/wiki/Basic-usage">Lettuce Basic-usage</a>:
//   *
//   * <p>Redis connections are designed to be long-lived and thread-safe, and if the connection is
//   * lost will reconnect until close() is called. Pending commands that have not timed out will be
//   * (re)sent after successful reconnection.
//   *
//   * @return <code>StatefulRedisConnection</code> created via start()
//   */
//  public StatefulRedisConnection<String, String> get() {
//    if (connection == null || !connection.isOpen()) {
//      start();
//    }
//    return connection;
//  }
//
//  public void stop() {
//    LOGGER.info("Closing connection to {}.", createRedisUri());
//    if (connection != null) {
//      connection.close();
//    }
//    if (redisClient != null) {
//      redisClient.shutdown();
//    }
//  }
//
//  private StatefulRedisConnection<String, String> connectClientWithRetry(final int retryCount) {
//    int retriesLeft = retryCount;
//    LOGGER.info("Connecting to Redis.");
//    StatefulRedisConnection<String, String> connection = null;
//    try {
//      connection = redisClient.connect();
//      LOGGER.info("Connection successful.");
//      return connection;
//    } catch (RedisConnectionException e) {
//      if (retriesLeft > 0) {
//        LOGGER.info(
//            "Problem connecting to Redis, retrying {} more times.  Cause: {}.",
//            retriesLeft,
//            e.getMessage());
//        return connectClientWithRetry(--retriesLeft);
//      } else {
//        LOGGER.error("Problem connecting to Redis, aborting attempt.");
//        throw new IllegalStateException("Cannot connect to Redis", e);
//      }
//    }
//  }
//
//  private String createRedisUri() {
//    return "redis://".concat(host).concat(":").concat(port);
//  }
//}
//
