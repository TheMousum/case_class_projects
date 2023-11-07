import scala.collection.mutable.ListBuffer

// BlogPost class representing individual blog posts with title, content, and author
case class BlogPost(title: String, content: String, author: String)

// BlogPostManagementSystem class with methods to add posts, view all posts, and find posts by author
class BlogPostManagementSystem {
  private val posts: ListBuffer[BlogPost] = ListBuffer()

  // Method to add a new blog post
  def addPost(title: String, content: String, author: String): Unit = {
    posts += BlogPost(title, content, author)
    println(s"Blog post '$title' added successfully.")
  }

  // Method to view all blog posts
  def viewAllPosts(): Unit = {
    println("All blog posts:")
    posts.foreach(post => println(s"Title: ${post.title}\nContent: ${post.content}\nAuthor: ${post.author}\n"))
  }

  // Method to find blog posts by a specific author
  def findPostsByAuthor(author: String): Unit = {
    val filteredPosts = posts.filter(_.author == author)
    if (filteredPosts.nonEmpty) {
      println(s"Blog posts by author '$author':")
      filteredPosts.foreach(post => println(s"Title: ${post.title}\nContent: ${post.content}\n"))
    } else {
      println(s"No blog posts found for author '$author'.")
    }
  }
}

// Main object to run the program
object Main {
  def main(args: Array[String]): Unit = {
    val blogSystem = new BlogPostManagementSystem()

    blogSystem.addPost("Scala Basics", "Introduction to Scala programming language.", "John Doe")
    blogSystem.addPost("Functional Programming", "Exploring functional programming concepts in Scala.", "Alice Smith")
    blogSystem.addPost("Pattern Matching", "Understanding pattern matching in Scala.", "John Doe")

    blogSystem.viewAllPosts()

    println("Posts by author 'John Doe':")
    blogSystem.findPostsByAuthor("John Doe")
  }
}
