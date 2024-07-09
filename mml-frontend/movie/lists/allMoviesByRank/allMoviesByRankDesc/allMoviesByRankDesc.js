fetch('http://localhost:8080/movie/allMovies/desc')
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(movie => {
            const rank = `<p>${movie.rank}</p>`;
            const title = `<p>${movie.movieTitle}</p>`;
            const score = `<p>${movie.score}</p>`;
            const length = `<p>${movie.movieHours}h ${movie.movieMinutes}m</p>`;
            const year = `<p>${movie.releaseYear}</p>`;
            const rating = `<p>${movie.rating}</p>`;
            const boxOffice = `<p>$${movie.boxOffice} Million</p>`;
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
    window.location.href = '../allMoviesByRankAsc/allMoviesByRankAsc.html';
})

document.getElementById('ScoreButton').addEventListener("click", function(){
    window.location.href = '../../allMoviesByScore/allMoviesByScoreAsc/allMoviesByScoreAsc.html';
})

document.getElementById('YearButton').addEventListener("click", function(){
    window.location.href = '../../allMoviesByYear/allMoviesByYearAsc/allMoviesByYearAsc.html';
})