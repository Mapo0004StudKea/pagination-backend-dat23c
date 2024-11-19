-- Script meant for a simple Java/Bootstrap/JPA Pagination example
-- Make sure to create the schema books_pagination before use (there's a reason to why the script does not create this)

use books_pagination;

DELETE FROM book where id>0;


INSERT INTO book (title, author) VALUES ('Harry Potter and the Philosopher''s Stone', 'J.K. Rowling');
INSERT INTO book (title, author) VALUES ('Harry Potter and the Chamber of Secrets', 'J.K. Rowling');
INSERT INTO book (title, author) VALUES ('Harry Potter and the Prisoner of Azkaban', 'J.K. Rowling');
INSERT INTO book (title, author) VALUES ('Harry Potter and the Goblet of Fire', 'J.K. Rowling');
INSERT INTO book (title, author) VALUES ('Harry Potter and the Order of the Phoenix', 'J.K. Rowling');
INSERT INTO book (title, author) VALUES ('Harry Potter and the Half-Blood Prince', 'J.K. Rowling');
INSERT INTO book (title, author) VALUES ('Harry Potter and the Deathly Hallows', 'J.K. Rowling');
INSERT INTO book (title, author) VALUES ('The Hunger Games', 'Suzanne Collins');
INSERT INTO book (title, author) VALUES ('Catching Fire', 'Suzanne Collins');
INSERT INTO book (title, author) VALUES ('Mockingjay', 'Suzanne Collins');
INSERT INTO book (title, author) VALUES ('The Fault in Our Stars', 'John Green');
INSERT INTO book (title, author) VALUES ('Divergent', 'Veronica Roth');
INSERT INTO book (title, author) VALUES ('Insurgent', 'Veronica Roth');
INSERT INTO book (title, author) VALUES ('Allegiant', 'Veronica Roth');
INSERT INTO book (title, author) VALUES ('The Maze Runner', 'James Dashner');
INSERT INTO book (title, author) VALUES ('The Scorch Trials', 'James Dashner');
INSERT INTO book (title, author) VALUES ('The Death Cure', 'James Dashner');
INSERT INTO book (title, author) VALUES ('Twilight', 'Stephenie Meyer');
INSERT INTO book (title, author) VALUES ('New Moon', 'Stephenie Meyer');
INSERT INTO book (title, author) VALUES ('Eclipse', 'Stephenie Meyer');
INSERT INTO book (title, author) VALUES ('Breaking Dawn', 'Stephenie Meyer');
INSERT INTO book (title, author) VALUES ('The Girl with the Dragon Tattoo', 'Stieg Larsson');
INSERT INTO book (title, author) VALUES ('The Girl Who Played with Fire', 'Stieg Larsson');
INSERT INTO book (title, author) VALUES ('The Girl Who Kicked the Hornets Nest', 'Stieg Larsson');
INSERT INTO book (title, author) VALUES ('A Game of Thrones', 'George R.R. Martin');
INSERT INTO book (title, author) VALUES ('A Clash of Kings', 'George R.R. Martin');
INSERT INTO book (title, author) VALUES ('A Storm of Swords', 'George R.R. Martin');
INSERT INTO book (title, author) VALUES ('A Feast for Crows', 'George R.R. Martin');
INSERT INTO book (title, author) VALUES ('A Dance with Dragons', 'George R.R. Martin');
INSERT INTO book (title, author) VALUES ('The Perks of Being a Wallflower', 'Stephen Chbosky');
INSERT INTO book (title, author) VALUES ('1984', 'George Orwell');
INSERT INTO book (title, author) VALUES ('Brave New World', 'Aldous Huxley');
INSERT INTO book (title, author) VALUES ('To Kill a Mockingbird', 'Harper Lee');
INSERT INTO book (title, author) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald');
INSERT INTO book (title, author) VALUES ('Pride and Prejudice', 'Jane Austen');
INSERT INTO book (title, author) VALUES ('The Catcher in the Rye', 'J.D. Salinger');
INSERT INTO book (title, author) VALUES ('Moby-Dick', 'Herman Melville');
INSERT INTO book (title, author) VALUES ('The Lord of the Rings: The Fellowship of the Ring', 'J.R.R. Tolkien');
INSERT INTO book (title, author) VALUES ('The Lord of the Rings: The Two Towers', 'J.R.R. Tolkien');
INSERT INTO book (title, author) VALUES ('The Lord of the Rings: The Return of the King', 'J.R.R. Tolkien');
INSERT INTO book (title, author) VALUES ('The Hobbit', 'J.R.R. Tolkien');
INSERT INTO book (title, author) VALUES ('One Hundred Years of Solitude', 'Gabriel García Márquez');
INSERT INTO book (title, author) VALUES ('The Kite Runner', 'Khaled Hosseini');
INSERT INTO book (title, author) VALUES ('The Book Thief', 'Markus Zusak');
INSERT INTO book (title, author) VALUES ('The Chronicles of Narnia: The Lion, the Witch and the Wardrobe', 'C.S. Lewis');
INSERT INTO book (title, author) VALUES ('The Chronicles of Narnia: Prince Caspian', 'C.S. Lewis');
INSERT INTO book (title, author) VALUES ('The Chronicles of Narnia: The Voyage of the Dawn Treader', 'C.S. Lewis');
INSERT INTO book (title, author) VALUES ('The Chronicles of Narnia: The Silver Chair', 'C.S. Lewis');
INSERT INTO book (title, author) VALUES ('The Chronicles of Narnia: The Horse and His Boy', 'C.S. Lewis');
INSERT INTO book (title, author) VALUES ('The Chronicles of Narnia: The Magician''s Nephew', 'C.S. Lewis');
INSERT INTO book (title, author) VALUES ('The Chronicles of Narnia: The Last Battle', 'C.S. Lewis');
INSERT INTO book (title, author) VALUES ('Fahrenheit 451','Ray Bradbury');
INSERT INTO book (title, author) VALUES ('Slaughterhouse-Five', 'Kurt Vonnegut');
INSERT INTO book (title, author) VALUES ('The Handmaid''s Tale', 'Margaret Atwood');
INSERT INTO book (title, author) VALUES ('The Picture of Dorian Gray', 'Oscar Wilde');
INSERT INTO book (title, author) VALUES ('The Alchemist', 'Paulo Coelho');
INSERT INTO book (title, author) VALUES ('The Road', 'Cormac McCarthy');
INSERT INTO book (title, author) VALUES ('The Count of Monte Cristo', 'Alexandre Dumas');
INSERT INTO book (title, author) VALUES ('Little Women', 'Louisa May Alcott');

