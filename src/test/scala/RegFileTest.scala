package xCache

// 导标准库
import chisel3._
import chiseltest._
import circt.stage.{ChiselStage, FirtoolOption}
import org.chipsalliance.cde.config._
import chisel3.stage.ChiselGeneratorAnnotation
import xs.utils.{ChiselDB, FileRegisters}
import freechips.rocketchip.diplomacy._
import freechips.rocketchip.tilelink._
import org.scalatest.flatspec.AnyFlatSpec

//class RegFileTest extends AnyFlatSpec with ChiselScalatestTester {
//  // 源文件将in和out相连，那么前后值应该保持不变
//  it should "test all" in {
//    test(new RegFile()) { c =>
//      for (i <- 0 until 16) {
//        c.io.in.poke(i.U)
//        println(s"i = ${i}, encoder = ${c.io.out.peek()}")
//      }
//    }
//
//  }
//}

//class RegFileTest()(implicit p: Parameters) extends LazyModule {
////  // 源文件将in和out相连，那么前后值应该保持不变
////  it should "test all" in {
////    test(new RegFile()) { c =>
////      for (i <- 0 until 16) {
////        c.io.in.poke(i.U)
////        println(s"i = ${i}, encoder = ${c.io.out.peek()}")
////      }
////    }
////
////  }
//}

object RegFileTest extends App {
  (new ChiselStage).execute(Array("--target", "verilog") ++ args, Seq(ChiselGeneratorAnnotation(() => new RegFile)))

  ChiselDB.init(false)
//  ChiselDB.addToFileRegisters
  FileRegisters.write("./build")
}