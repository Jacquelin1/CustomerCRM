package com.atguigu.chap02.customercrm.service

import com.atguigu.chap02.customercrm.bean.Customer

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

class CustomerService {

  var customerNum = 1

  val customers = ArrayBuffer(new Customer(1, "tom", '男', 10, "100", "tom@sina.com"))

  def list(): ArrayBuffer[Customer] = {
    this.customers
  }

  def add(customer: Customer): Boolean = {
    customerNum += 1
    customer.id = customerNum
    customers.append(customer)
    true

  }

  def del(id: Int): Boolean = {
    val index = findIndexById(id)
    if (index != -1) {
      //删除
      customers.remove(index)
      true
    } else {
      false //=-1不删除
    }
  }

  def findIndexById(id: Int) = {
    var index = -1 //客户端输入1就代表用户反悔，不想删除
    breakable {
      for (i <- 0 until customers.length) {
        if (customers(i).id == id) { //找到了
          index = i
          break()
        }
      }
    }
    index
  }

}
