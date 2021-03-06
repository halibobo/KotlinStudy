package me.dahei.myapplication.basic

import android.text.TextUtils
import me.dahei.myapplication.GenerateNote
import me.dahei.myapplication.data.KotlinNote
import me.dahei.myapplication.data.NoteItem

class BasicGrammar : GenerateNote{

    override fun note(): KotlinNote {
        return KotlinNote(arrayListOf(
                NoteItem("\n" +
                        "    /**\n" +
                        "     * 带有两个 Int 参数、返回 Int 的函数：\n" +
                        "     */\n" +
                        "    private fun sum(a: Int, b: Int): Int {\n" +
                        "        return a + b\n" +
                        "    }",
                        "sum(2, 3)",
                        sum(2, 3).toString()),
                NoteItem("\n" +
                        "    /**\n" +
                        "     * 将表达式作为函数体、返回值类型自动推断的函数\n" +
                        "     */\n" +
                        "    private fun sum(a: Int, b: Int, c: Int) = a + b + c\n",
                        "sum(2, 3, 4)",
                        sum(2, 3, 4).toString()),
                NoteItem("\n" +
                        "    /**\n" +
                        "     * 使用字符串模版\n" +
                        "     */\n" +
                        "    private fun connectStr():String {\n" +
                        "        var a = 1\n" +
                        "        val s1 = \"a is \$a\"\n" +
                        "        a = 2\n" +
                        "        val s2 = \"\${s1.replace('is', 'was')}, but now is \$a\"\n" +
                        "        return s2\n" +
                        "    }",
                        "connectStr()",
                        connectStr()),
                NoteItem("\n" +
                        "    /**\n" +
                        "     * 使用 if 作为表达式:\n" +
                        "     */\n" +
                        "    fun maxOf(a: Int, b: Int) = if (a > b) a else b",
                        "maxOf(123, 43)",
                        maxOf(123, 43).toString()),
                NoteItem("\n" +
                        "    /**\n" +
                        "     * 当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。\n" +
                        "     * 如果 str 的内容不是数字返回 null：\n" +
                        "     */\n" +
                        "    private fun parseInt(str: String): Int? {\n" +
                        "        return str.toInt()\n" +
                        "    }",
                        "parseInt('12332'), parseInt(\"\")",
                        "${testParseInt("12332")}, ${testParseInt("")}")
        ), "基本语法")
    }

    /**
     * 带有两个 Int 参数、返回 Int 的函数：
     */
    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 将表达式作为函数体、返回值类型自动推断的函数
     */
    private fun sum(a: Int, b: Int, c: Int) = a + b + c


    /**
     * 无意义的返回值
     */
    private fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    /**
     * 返回值Unit可以省略
     */
    private fun printSum(a: String, b: String) {
        println("sum of $a and $b is ${a + b}")
    }

    /**
     * 使用字符串模版
     */
    private fun connectStr():String {
        var a = 1
        val s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        return s2
    }

    /**
     * 使用 if 作为表达式:
     */
    private fun maxOf(a: Int, b: Int) = if (a > b) a else b


    /**
     * 当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
     * 如果 str 的内容不是数字返回 null：
     */
    private fun testParseInt(str: String): Int? {
        if (TextUtils.isEmpty(str)) {
            return null
        }else {
            return Integer.parseInt(str)
        }
    }
}