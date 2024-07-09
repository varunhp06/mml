fetch('http://localhost:8080/movie/allMovies/year/desc')
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(movie => {
            const markup = `<li>
                                    <ul>${movie.rank}</ul>
                                    <ul>${movie.movieTitle}</ul>
                                    <ul>${movie.score}</ul>
                                    <ul>${movie.movieHours}h ${movie.movieMinutes}m</ul>
                                    <ul>${movie.releaseYear}</ul>
                                    <ul>${movie.rating}</ul>
                                    <ul>$${movie.boxOffice} Million</ul> 
                                </li>`;
            document.querySelector('#allMoviesByYearDesc').insertAdjacentHTML('beforeend', markup);
        })
    })
    .catch(error => console.log(error));