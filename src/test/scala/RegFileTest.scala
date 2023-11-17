
// 包名
package cpu

// 导标准库
import chisel3._
import chiseltest._

import org.scalatest.flatspec.AnyFlatSpec

class RegFileTest extends AnyFlatSpec with ChiselScalatestTester {
  // 源文件将in和out相连，那么前后值应该保持不变
  it should "test all" in {
    test(new RegFile()) { c =>
      for (i <- 0 until 16) {
        c.io.in.poke(i.U)
        println(s"i = ${i}, encoder = ${c.io.out.peek()}")
      }
    }

  }
}