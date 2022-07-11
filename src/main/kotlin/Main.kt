import java.sql.DriverManager

data class Doctor(val id: Int, val name: String, val age: Int)

fun main(args: Array<String>) {
    println("Hello World!")



        val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"

        val connection = DriverManager.getConnection(jdbcUrl, "postgres", "postgres")
        println(connection.isValid(0))
        val query = connection.prepareStatement("SELECT * FROM doc")
        val result = query.executeQuery()
        val doctors = mutableListOf<Doctor>()

        while(result.next()){

            val id = result.getInt("doc_id")
            val name = result.getString("name")
            val age = result.getInt("age")
            doctors.add(Doctor(id, name, age))
        }

        println(doctors)
    }

