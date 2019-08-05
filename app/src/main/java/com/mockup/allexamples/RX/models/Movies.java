package com.mockup.allexamples.RX.models;



import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mockup.allexamples.RX.models.Movie;

public class Movies {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_Movies")
    @Expose
    private Integer totalMovies;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("Movies")
    @Expose
    private List<Movie> Movies = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Movies() {
    }

    /**
     *
     * @param Movies
     * @param totalMovies
     * @param page
     * @param totalPages
     */
    public Movies(Integer page, Integer totalMovies, Integer totalPages, List<Movie> Movies) {
        super();
        this.page = page;
        this.totalMovies = totalMovies;
        this.totalPages = totalPages;
        this.Movies = Movies;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalMovies() {
        return totalMovies;
    }

    public void setTotalMovies(Integer totalMovies) {
        this.totalMovies = totalMovies;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getMovies() {
        return Movies;
    }

    public void setMovies(List<Movie> Movies) {
        this.Movies = Movies;
    }

}