package com.atguigu.chap02.customercrm.view

import com.atguigu.chap02.customercrm.bean.Customer
import com.atguigu.chap02.customercrm.service.CustomerService

import scala.io.StdIn

class CustomerView {

  var loop = true
  var key = ' '
  val customerService = new CustomerService()

  def mainMenu(): Unit = {
    do {

      println("-----------------客户信息管理软件-----------------")
      println("                  1添加客户")
      println("                  2修改客户")
      println("                  3删除客户")
      println("                  4客户列表")
      println("                  5退出")
      println("请选择(1-5):")

      key = StdIn.readChar()
      key match {
        case '1' => this.add()
        case '2' => println("修改客户")
        case '3' => this.del()
        case '4' => this.list()
        case '5' => this.loop = false

      }
    } while (loop)
    println("你退出了软件系统")

  }

  def list(): Unit = {
    println()
    println("---------------------------客户列表---------")
    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱")
    val customers = customerService.list()
    for (customer <- customers) {
      println(customer)
    }

    println("-------------------------客户列表完成--------")

  }

  def add(): Unit = {
    println()
    println("---------------------添加客户---------------------")
    println("姓名")
    val name = StdIn.readLine()
    println("性别")
    val gender = StdIn.readChar()
    println("年龄")
    val age = StdIn.readShort()
    println("电话")
    val tel = StdIn.readLine()
    println("邮箱")
    val email = StdIn.readLine()

    val customer = new Customer(name, gender, age, tel, email)
    customerService.add(customer)
    println("---------------------添加完成---------------------")

  }

  def del():Unit={
    println("---------------------删除客户---------------------")
    println("请选择待删除客户编号(-1 退出):")
    val id = StdIn.readInt()
    if (id == -1) {
      println("---------------------删除没有完成---------------------")
      return
    }
    println("确认是否删除(Y/N):")
    val choice =StdIn.readChar().toLower
    if (choice=='y'){
      if(customerService.del(id)){
        println("---------------------删除完成---------------------")
        return
      }
    }
    println("---------------------删除没有完成---------------------")

  }


}
