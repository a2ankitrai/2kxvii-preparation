# System Design

Designing a high-level architecture for some sort of a software system.

## Some examples

- Design a URL shortening service like bit.ly.

- How would you implement the Google search?

- Design a client-server application which allows people to play chess with one another.

- How would you store the relations in a social network like Facebook and implement a feature where one user receives notifications when their friends like the same things as they do?

The idea of these questions is to have a discussion about the problem at hand. What’s important for the interviewer is the process, which you use to tackle the problem. The typical outcome of such a discussion is a high-level architecture addressing the goals and constraints in the question. Perhaps the interviewer will choose one or more areas where they will want to discuss bottlenecks and other common problems.

### Clarify the constraints and identify the user cases

Spend a few minutes questioning the interviewer and agreeing on the scope of the system. Remember to make sure you know all the requirements the interviewer didn't tell you about in the beginning.

User cases indicate the main functions of the system, and constraints list the scale of the system such as requests per second, requests types, data written per second, data read per second.

### High-level architecture design

Sketch the important components and the connections between them, but don't go into some details. Usually, a scalable system includes webserver (load balancer), service (service partition), database (master/slave database cluster plug cache). Figure out vertical and horizontal scalabilities of these based on number of users.

### Component design

For each component, you need to write the specific APIs for each component. You may need to finish the detailed OOD design for a particular function. You may also need to design the database schema for the database.

we can divide our architecture in two logical parts: 1) the logic, which will handle all incoming requests to the application and 2) the data storage that we will use to store all the data that needs to be persisted. If you learn enough about popular software systems, especially the ones that are accessed through a web browser you will notice that such a breakdown is quite popular and natural.

---

## At the interview

So what should you do at your interview?

First of all, follow the System Design Process. Don't skip steps, don't make assumptions, start broad and go deep when asked.

Second, keep in mind that system design questions serve as an idea exchange platform. Be prepared for discussions about tradeoffs, about pros and cons. Be prepared to give alternatives, to ask questions, to identify and solve bottlenecks, to go broad or deep depending on your interviewer's preferences.

Don't get defensive: whenever your interviewer challenges your architectural choices, acknowledge that rarely an idea is perfect, and outline the advantages and disadvantages of your choice. Be open to new constraints to pop up during the discussion and to adjust your architecture on the fly.

Most of all, have fun. Dreaming up architectures is a very stimulating mental process - enjoy it and stay positive. You're already equipped with the right knowledge, just apply it during your interview and you'll do well.

---

## scalability

A service is said to be scalable if when we increase the resources in a system, it results in increased performance in a manner proportional to resources added. Increasing performance in general means serving more units of work, but it can also be to handle larger units of work, such as when datasets grow.


---

## Basic knowledge about System Design

- [Scalable Web Architecture and Distributed Systems](http://www.aosabook.org/en/distsys.html)

- [CAP](https://github.com/henryr/cap-faq)

- [Introduction to Architecting Systems for Scale](http://lethain.com/introduction-to-architecting-systems-for-scale/)

- [Scalable System Design Patterns](http://horicky.blogspot.in/2010/10/scalable-system-design-patterns.html)

- [Consistent Hashing](http://www.tom-e-white.com/2007/11/consistent-hashing.html)

	![consistent_hashing](./_image/consistent_hashing.png)
	
	In caching Since the overall hashtable is distributed across many VNs, we need a way to map each key to the corresponding VN. If you have a collection of `n` cache machines then a common way of load balancing across them is to put object `o` in cache machine number `hash(o) mod n`. This works well until you add or remove cache machines (for whatever reason), for then `n` changes and every object is hashed to a new location. This can be catastrophic since the originating content servers are swamped with requests from the cache machines. It's as if the cache suddenly disappeared. 

	The disadvantage of this scheme : when we alter the number of VNs, then the ownership of existing keys has changed dramatically, which requires full data redistribution. Most large scale store use a "consistent hashing" technique to minimize the amount of ownership changes.
	
	The basic idea behind the consistent hashing algorithm is to hash both objects and caches using the same hash function. The reason to do this is to map the cache to an interval, which will contain a number of object hashes. If the cache is removed then its interval is taken over by a cache with an adjacent interval. All the other caches remain unchanged.
	
	In the consistent hashing scheme, the key space is finite and lie on the circumference of a ring. The virtual node id is also allocated from the same key space. For any key, its owner node is defined as the first encountered virtual node if walking clockwise from that key. If the owner node crashes, all the key it owns will be adopted by its clockwise neighbor. Therefore, key redistribution happens only within the neighbor of the crashed node, all other nodes retains the same set of keys.
	
- [NOSQL Patterns](http://horicky.blogspot.in/2009/11/nosql-patterns.html)	

- **service oriented architectures**, map-reduce, distributed caching, load balancing,
- how browsers work at a high level, 
- from DNS lookups and 
- TCP/IP, 
- to socket connections.	

- n-tiered software architecture 

- Amazon Elastic Compute Cloud (Amazon 
EC2), 
-Amazon Simple Storage Service (Amazon S3), 

-Amazon SimpleDB, Amazon Simple Queue Service (Amazon SQS),

- Amazon Flexible Payments Service (Amazon FPS), 
- Amazon Mechanical Turk, and Amazon CloudFront.	
	
	
---

## Products and Systems:

- [MapReduce: Simplied Data Processing on Large Clusters](./_docs/mapreduce-osdi04.pdf)

---

### Some Famous Designs

- [Google Docs](http://blog.gainlo.co/index.php/2016/03/22/system-design-interview-question-how-to-design-google-docs/)

---

## Uber

