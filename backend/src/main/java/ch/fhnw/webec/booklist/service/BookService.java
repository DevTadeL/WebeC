package ch.fhnw.webec.booklist.service;

import ch.fhnw.webec.booklist.model.Book;
import ch.fhnw.webec.booklist.model.Topic;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class BookService {
    private final Map<Integer, Book> books = new HashMap<>();

    @PostConstruct
    public void postConstruct() {
        this.addOrUpdate(new Book(
            "HTML and CSS: Design and Build Websites",
            "Every day, more and more people want to learn some HTML and CSS. Joining the professional web designers and programmers are new audiences who need to know a little bit of code at work (update a content management system or e-commerce store) and those who want to make their personal blogs more attractive. ",
            Set.of(Topic.WEB)
        ));
        this.addOrUpdate(new Book(
            "CSS: The Definitive Guide: Visual Presentation for the Web",
            "If you're a web designer or app developer interested in sophisticated page styling, improved accessibility, and saving time and effort, this book is for you. This revised edition provides a comprehensive guide to CSS implementation, along with a thorough review of the latest CSS specifications. CSS is a constantly evolving language for describing the presentation of web content on screen, printers, speech synthesizers, screen readers, and chat windows. It is used by all browsers on all screen sizes on all types of IoT devices, including phones, computers, video games, televisions, watches, kiosks, and auto consoles. ",
            Set.of(Topic.WEB)
        ));
        this.addOrUpdate(new Book(
            "System Design Interview – An insider's guide",
            "The system design interview is considered to be the most complex and most difficult technical job interview by many. This book provides a step-by-step framework on how to tackle a system design question. It includes many real-world examples to illustrate the systematic approach with detailed steps that you can follow.",
            Set.of(Topic.ARCHITECTURE)
        ));
        this.addOrUpdate(new Book(
            "Relational Database Systems",
            "Relational Database Systems provides a timely introduction to the type of systems that are the current mainstay of the database management field. This book serves as a text for advanced undergraduate and graduate students, as well as an informative reference for researchers and professionals in all database aspects of computer science. It presents important querying systems including SQL and QUEL, and covers their respective theoretical foundations in relational algebra, tuple calculus, and domain calculus.",
            Set.of(Topic.DATABASE)
        ));
        this.addOrUpdate(new Book(
            "Database Internals: A Deep-Dive Into How Distributed Data Systems Work",
            "When it comes to choosing, using, and maintaining a database, understanding its internals is essential. But with so many distributed databases and tools available today, it’s often difficult to understand what each one offers and how they differ. With this practical guide, Alex Petrov guides developers through the concepts behind modern database and storage engine internals. Throughout the book, you’ll explore relevant material gleaned from numerous books, papers, blog posts, and the source code of several open source databases.",
            Set.of(Topic.DATABASE)
        ));
        this.addOrUpdate(new Book(
            "The Pragmatic Programmer",
            "-- Ward Cunningham Straight from the programming trenches, The Pragmatic Programmer cuts through the increasing specialization and technicalities of modern software development to examine the core process -- taking a requirement and producing working, maintainable code that delights its users. It covers topics ranging from personal responsibility and career development to architectural techniques for keeping your code flexible and easy to adapt and reuse.",
            Set.of(Topic.PROGRAMMING)
        ));
        this.addOrUpdate(new Book(
            "JavaScript: The Good Parts",
            "The Pragmatic Programmer cuts through the increasing specialization and technicalities of modern software development to examine the core process taking a requirement and producing working, maintainable code that delights its users. It covers topics ranging from personal responsibility and career development to architectural techniques for keeping your code flexible and easy to adapt and reuse.",
            Set.of(Topic.PROGRAMMING)
        ));
        this.addOrUpdate(new Book(
            "Javascript: The Definitive Guide: Master the World's Most-Used Programming Language",
            "JavaScript is the programming language of the web and is used by more software developers today than any other programming language. For nearly 25 years this best seller has been the go-to guide for JavaScript programmers. The seventh edition is fully updated to cover the 2020 version of JavaScript, and new chapters cover classes, modules, iterators, generators, Promises, async/await, and metaprogramming. You'll find illuminating and engaging example code throughout.",
            Set.of(Topic.WEB, Topic.PROGRAMMING)
        ));
        this.addOrUpdate(new Book(
            "Web Coding & Development All-in-One For Dummies",
            "With more high-paying web development jobs opening every day, people with coding and web/app building skills are having no problems finding employment. If you're a would-be developer looking to gain the know-how to build the interfaces, databases, and other features that run modern websites, web apps, and mobile apps, look no further. Web Coding & Development All-in-One For Dummies is your go-to interpreter for speaking the languages that handle those tasks.",
            Set.of(Topic.WEB, Topic.PROGRAMMING)
        ));
        this.addOrUpdate(new Book(
            "Programming in Haskell",
            "Haskell is a purely functional language that allows programmers to rapidly develop clear, concise, and correct software. The language has grown in popularity in recent years, both in teaching and in industry. This book is based on the author's experience of teaching Haskell for more than twenty years. All concepts are explained from first principles and no programming experience is required, making this book accessible to a broad spectrum of readers.",
            Set.of(Topic.PROGRAMMING)
        ));
        this.addOrUpdate(new Book(
            "Fundamentals of Software Architecture: An Engineering Approach",
            "Salary surveys worldwide regularly place software architect in the top 10 best jobs, yet no real guide exists to help developers become architects. Until now. This book provides the first comprehensive overview of software architecture’s many aspects. Aspiring and existing architects alike will examine architectural characteristics, architectural patterns, component determination, diagramming and presenting architecture, evolutionary architecture, and many other topics.",
            Set.of(Topic.ARCHITECTURE)
        ));
        this.addOrUpdate(new Book(
            "Algorithms and Data Structures: The Basic Toolbox",
            "Algorithms are at the heart of every nontrivial computer application, and algorithmics is a modern and active area of computer science. Every computer scientist and every professional programmer should know about the basic algorithmic toolbox: structures that allow efficient organization and retrieval of data, frequently used algorithms, and basic techniques for modeling, understanding and solving algorithmic problems.",
            Set.of(Topic.ALGORITHMS)
        ));
        this.addOrUpdate(new Book(
            "Introduction to Algorithms",
            "The latest edition of the essential text and professional reference, with substantial new material on such topics as vEB trees, multithreaded algorithms, dynamic programming, and edge-based flow. Some books on algorithms are rigorous but incomplete; others cover masses of material but lack rigor. Introduction to Algorithms uniquely combines rigor and comprehensiveness. The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.",
            Set.of(Topic.ALGORITHMS)
        ));
    }

    public void addOrUpdate(Book book) {
        if (book.getId() <= 0) {
            book.setId(this.getNextId());
        }

        this.books.put(book.getId(), book);
    }

    public List<Book> findAll() {
        return new ArrayList<>(this.books.values());
    }

    private int getNextId() {
        return this.books.values().stream().map(Book::getId).reduce(Integer::max).orElse(0) + 1;
    }
}
