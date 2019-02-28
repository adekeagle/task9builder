package model;

import java.sql.Date;
import java.util.List;

public class Article {
    private long id;
    private String title;
    private String content;
    private Date publishDate;
    private List<Tag> tags;
    private Category category;
    private Author author;

    public static NeedId builder(){
        return new Builder();
    }

    public static class Builder implements NeedId, NeedTitle, NeedContent, NeedPublishDate, AndNext, CanBeBuild{
        private long id;
        private String title;
        private String content;
        private Date publishDate;
        private List<Tag> tags;
        private Category category;
        private Author author;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder content(String content){
            this.content = content;
            return this;
        }

        public Builder publishDate(Date publishDate){
            this.publishDate = publishDate;
            return this;
        }

        public Builder addTag(Tag tag){
            tags.add(tag);
            return this;
        }

        public Builder category(Category category){
            this.category = category;
            return this;
        }

        public Builder author(Author author){
            this.author = author;
            return this;
        }

        public Builder and(){
            return this;
        }

        public Article build(){
            Article article = new Article();
            article.id = this.id;
            article.title = this.title;
            article.content = this.content;
            article.publishDate = this.publishDate;
            article.tags = this.tags;
            article.category = this.category;
            article.author = this.author;

            return article;
        }
    }

    public interface NeedId
    {
        NeedTitle id(long id);
    }

    public interface NeedTitle
    {
        NeedContent title(String title);
    }

    public interface NeedContent
    {
        NeedPublishDate content(String content);
    }

    public interface NeedPublishDate
    {
        AndNext publishDate(Date publishDate);
    }

    public interface AndNext
    {
        CanBeBuild and();
    }

    public interface CanBeBuild
    {
        CanBeBuild addTag(Tag tag);
        CanBeBuild category(Category category);
        CanBeBuild author(Author author);

        Article build();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", tags=" + tags +
                ", category=" + category +
                ", author=" + author +
                '}';
    }
}
