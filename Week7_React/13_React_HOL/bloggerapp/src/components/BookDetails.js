function BookDetails ({books}){
    return(
        <ul>
            {books.map(book =>(
                <div key = {book.id}>
                    <h3>Book Name: {book.bname}</h3>
                    <h4>Price: {book.price}</h4>
                </div>
            ))}
        </ul>
    );
}
export default BookDetails;