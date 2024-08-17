document.getElementById('movie').addEventListener("click", function(){
    window.location.href = `../movie/lists/allMoviesByRank/allMoviesByRankAsc/allMoviesByRankAsc.html`;
})
document.getElementById('show').addEventListener("click", function(){
    window.location.href = `../tv/lists/allShowsByRank/allShowsByRankAsc/allShowsByRankAsc.html`;
})
document.getElementById('LogIn').addEventListener("click", function(){
    window.location = `http://localhost:8080/login`;
})