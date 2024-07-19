fetch('http://localhost:8080/movie/allMovies/year/desc')
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(movie => {
            const rank = `<p>${movie.rank}</p>`;
            const title = `<p><a href='../../../allMoviesById/allMoviesById.html?index=${movie.rank}'">${movie.movieTitle}</a></p>`;
            let score;
            if ((movie.score > 8 && movie.score < 9) || (movie.score > 9 && movie.score < 10)) score = `<p>${movie.score}</p>`;
            else score = `<p>${movie.score}.0</p>`;
            const length = `<p>${movie.movieHours}h ${movie.movieMinutes}m</p>`;
            const year = `<p>${movie.releaseYear}</p>`;
            const rating = `<p>${movie.rating}</p>`;
            let boxOffice;
            if (movie.boxOffice >= 1 && movie.boxOffice < 1000) boxOffice = `<p>$${movie.boxOffice} Million</p>`;
            else if (movie.boxOffice >= 1000) boxOffice = `<p>$${movie.boxOffice/1000} Billion</p>`;
            else if (movie.boxOffice < 0) boxOffice = `<p>No Info</p>`
            else boxOffice = `<p>$${Math.floor(movie.boxOffice*1000)},${Math.floor((movie.boxOffice*1000000)%1000)}</p>`;
            document.querySelector('#movieRank').insertAdjacentHTML('beforeend', rank);
            document.querySelector('#movieTitle').insertAdjacentHTML('beforeend', title);
            document.querySelector('#movieScore').insertAdjacentHTML('beforeend', score);
            document.querySelector('#movieLength').insertAdjacentHTML('beforeend', length);
            document.querySelector('#movieYear').insertAdjacentHTML('beforeend', year);
            document.querySelector('#movieRating').insertAdjacentHTML('beforeend', rating);
            document.querySelector('#movieBoxOffice').insertAdjacentHTML('beforeend', boxOffice);
        })
    })
    .catch(error => console.log(error));

document.getElementById('RankButton').addEventListener("click", function(){
    window.location.href = '../../allMoviesByRank/allMoviesByRankAsc/allMoviesByRankAsc.html';
})

document.getElementById('ScoreButton').addEventListener("click", function(){
    window.location.href = '../../allMoviesByScore/allMoviesByScoreAsc/allMoviesByScoreAsc.html';
})

document.getElementById('YearButton').addEventListener("click", function(){
    window.location.href = '../allMoviesByYearAsc/allMoviesByYearAsc.html';
})