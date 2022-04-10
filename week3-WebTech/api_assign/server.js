import express, { application } from 'express';
import path from 'path';
// import app from './app/app-route.js';
import Books from './js/books.js';
import Cars from './js/cars.js';
import Persons from './js/Persons.js';


const server = express();
const port = 3000;
server.use(express.urlencoded({ extended: true }));
server.use(express.json());
const __dirname = path.resolve(path.dirname(""));


server.get('/', (req, resp) => {
    resp.setHeader('Content-Type', "text/html");
    // resp.send({message:"Welcome to Express Server"});
    resp.sendFile(__dirname + "/index.html");
});


// ----------------------------------------------------
// Book API 
// ----------------------------------------------------
let books = []

books.push(new Books(1, 'name1', 'author1', 100));
books.push(new Books(2, 'name2', 'author2', 100));
books.push(new Books(3, 'name3', 'author3', 100));

// Read
server.get("/books", (req, res) => {
    res.setHeader("Content-Type", 'application/json');
    res.send(books);
})


server.get("/books/:bookid", (req, res) => {
    res.setHeader("Content-Type", 'application/json');
    // res.send(books[]);f
    const book = books.find(b => b.bookid == req.params.bookid)
    if (book) {
        res.send(book);
    }
    else {
        res.status(404).send('Book not found');
    }
})

// server.delete('/books/:bookid', (req, resp) => {
//     resp.setHeader('Content-Type', 'application/json');
//     const delete_bookid = req.params.bookid;
//     books.forEach(book => {
//         if (book.bookid === req.params.bookid) {
//             books.pop();
//         }
//     });
//     resp.redirect('/books')
// })

// Create 
server.post("/books/add", (req,resp)=>{
    resp.setHeader('Content-Type', 'application/json');
    let bookid = req.body.bookid;
    let bookname = req.body.bookname;
    let authorname = req.body.authorname;
    let unitprice= req.body.unitprice;
    books.push(new Books(bookid, bookname, authorname, unitprice));
    resp.send('Book added');
})
// Delete 
server.get("/books/delete/:bookid", (req,res)=>{
    res.setHeader('Content-Type','application/json');
    let temp = [];
    for  (let i in books) {
        if (req.params.bookid != books[i].bookid){
            temp.push(books[i]);
        }
    }
    books = temp;
    //2 deleted ..
    res.redirect('/books');
})

// Update 
server.put('/books/:bookid/:unitprice', (req, resp) => {

    resp.setHeader('Content-Type', 'application/json');
    const bid = req.params.bookid;
    // console.log(bid)
    const book = books.find(b => b.bookid == bid);
    if (book) {

        book.unitprice = req.params.unitprice;

        resp.send(JSON.stringify(book) + " updated with new price");

    }
    else {

        resp.status(404).send(bid + " No product found");

    }
});


// ----------------------------------------------------
// Person API 
// ----------------------------------------------------
let persons = []

persons.push(new Persons(1, "fname1", "lname1", 20, "M"));
persons.push(new Persons(2, "fname2", "lname2", 30, "M"));
persons.push(new Persons(3, "fname3", "lname3", 20, "F"));

// Read
server.get("/persons", (req, res) => {
    res.setHeader("Content-Type", 'application/json');
    res.send(persons);
})


server.get("/persons/:pid", (req, res) => {
    res.setHeader("Content-Type", 'application/json');
    // res.send(books[]);f
    const person = persons.find(p => p.pid == req.params.pid)
    if (person) {
        res.send(person);
    }
    else {
        res.status(404).send('Person not found');
    }
})

// server.delete('/books/:bookid', (req, resp) => {
//     resp.setHeader('Content-Type', 'application/json');
//     const delete_bookid = req.params.bookid;
//     books.forEach(book => {
//         if (book.bookid === req.params.bookid) {
//             books.pop();
//         }
//     });
//     resp.redirect('/books')
// })

// Create 
server.post("/persons/add", (req,resp)=>{
    resp.setHeader('Content-Type', 'application/json');
    let pid = req.body.pid;
    let fname = req.body.firstName;
    let lname = req.body.lastName;
    let age= req.body.age;
    let gen=req.body.gender;
    persons.push(new Persons(pid, fname, lname, age, gen));
    resp.send('Person added');
})
// Delete 
server.get("/persons/delete/:pid", (req,res)=>{
    res.setHeader('Content-Type','application/json');
    let temp = [];
    for  (let i in persons) {
        if (req.params.pid != persons[i].pid){
            temp.push(persons[i]);
        }
    }
    persons = temp;
    res.redirect('/persons');
})

// Update 
server.put('/persons/:pid/:age', (req, resp) => {
    resp.setHeader('Content-Type', 'application/json');
    const per_id = req.params.pid;
    console.log(per_id)
    const person = persons.find(p => p.pid == per_id);
    if (person) {
        person.age = req.params.age;
        resp.send(JSON.stringify(person) + " updated with new age");
    }
    else {
        resp.status(404).send(per_id + " No person found");
    }
});


// ----------------------------------------------------
// Cars API 
// ----------------------------------------------------
let cars = []

cars.push(new Cars(1,'audi', 'A101', 100));
cars.push(new Cars(2,'bmw', 'B201', 200));
cars.push(new Cars(3,'ford', 'C301', 50));

// Read
server.get("/cars", (req, res) => {
    res.setHeader("Content-Type", 'application/json');
    res.send(cars);
})

server.get("/cars/:carid", (req, res) => {
    res.setHeader("Content-Type", 'application/json');
    // res.send(cars[]);f
    const car = cars.find(c => c.carid == req.params.carid)
    if (car) {
        res.send(car);
    }
    else {
        res.status(404).send('Car not found');
    }
});

// Create 
server.post("/cars/add", (req,resp)=>{
    resp.setHeader('Content-Type', 'application/json');
    let carid = req.body.carid;
    let carName = req.body.carName;
    let carModel = req.body.carModel;
    let carPrice= req.body.carPrice;
    cars.push(new Cars(carid, carName, carModel, carPrice));
    resp.send('Car added');
})

// Delete 
server.get("/cars/delete/:carid", (req,res)=>{
    res.setHeader('Content-Type','application/json');
    let temp = [];
    for  (let i in cars) {
        if (req.params.carid != cars[i].carid){
            temp.push(cars[i]);
        }
    }
    cars = temp;
    res.redirect('/cars');
})

// Update 
server.put('/cars/:carid/:carprice', (req, resp) => {
    resp.setHeader('Content-Type', 'application/json');
    const cid = req.params.carid;
    console.log(cid)
    const car = cars.find(c => c.carid == cid);
    if (car) {
        car.carprice = req.params.carprice;
        resp.send(JSON.stringify(car) + " updated with new price");
    }
    else {
        resp.status(404).send(cid + " No product found");
    }
});



server.listen(port, () => { console.log("http://localhost:3000"); })