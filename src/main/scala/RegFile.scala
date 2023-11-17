// 包名，就是修改后的工程文件名
package cpu

// 导包
import chisel3._
import chisel3.util._
import chisel3.util.experimental.BoringUtils
//import org.chipsalliance.cde.config._

// 将输入端口连接到输出端口，这样io.in驱动io.out。注意:=运算符是一个Chisel运算符，表示右侧信号驱动左侧信号。它是一个定向运算符。
class RegFile extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(2.W))
  })
  private val encoder: UInt = PriorityEncoder(io.in)
  io.out := encoder
}




// 创建xxxGenRTL文件，后缀自定义
// TO DO: 释义
object RegFileGenRTL extends App {
  // val defaultConfig = new Config((_,_,_) => {
  //     case MyProjectParamsKey => MyProjectParameters(
  //       simulation = false
  //     )
  // })

  println("Generating the RegFile hardware")
  (new chisel3.stage.ChiselStage).emitVerilog(new RegFile, Array("--target-dir", "build"))
}
