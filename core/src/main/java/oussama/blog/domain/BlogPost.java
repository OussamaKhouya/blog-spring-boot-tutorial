package oussama.blog.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class BlogPost {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String title;

  @NotNull
  @Column(columnDefinition = "TEXT")
  private String preview;

  @NotNull
  @Column(columnDefinition = "TEXT")
  private String content;

  @CreatedDate
  @NotNull
  private Date dateCreated;

  @LastModifiedDate
  private Date lastUpdated;

  public BlogPost() {}

  public BlogPost(Long id, String title, String preview, String content, Date dateCreated, Date lastUpdated) {
    this.id = id;
    this.title = title;
    this.preview = preview;
    this.content = content;
    this.dateCreated = dateCreated;
    this.lastUpdated = lastUpdated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}
