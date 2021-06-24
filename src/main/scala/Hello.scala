import org.slf4j.Logger

class Hello(log: Logger) {
  def sayHello(): Unit = {
    log.info("Hello, world!")
  }
}

