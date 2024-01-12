package xCache

// 导包
import chisel3._
import chisel3.util._
import chisel3.util.experimental.BoringUtils
//import org.chipsalliance.cde.config._

class RegFile extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(2.W))
  })
  private val encoder: UInt = PriorityEncoder(io.in)
  io.out := encoder
}

