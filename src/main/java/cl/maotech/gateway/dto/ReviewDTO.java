
package cl.maotech.gateway.dto;

public class ReviewDTO {
    
    private Integer id;
    private Integer value;
    private String review;
    private Long courseId;
    
    public ReviewDTO() {
    }
    
    public ReviewDTO(Integer id, Integer value, String review, Long courseId) {
        this.id = id;
        this.value = value;
        this.review = review;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    
}