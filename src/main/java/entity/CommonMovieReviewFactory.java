package entity;
import java.util.Date;
import javax.xml.crypto.Data;

public class CommonMovieReviewFactory implements MovieReviewFactory {

    public MovieReview create(String user, Date date, Double starRating, String writtenReview, String movieTitle) {
        return new CommonMovieReview(user, date, starRating, writtenReview, movieTitle);
    }

    public MovieReview create(String user, Date date, Double starRating, String movieTitle) {
        return new CommonMovieReview(user, date, starRating, movieTitle);
    }

}
