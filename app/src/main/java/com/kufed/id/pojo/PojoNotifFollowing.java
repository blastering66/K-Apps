package com.kufed.id.pojo;

/**
 * Created by macbook on 7/15/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class PojoNotifFollowing {
    @SerializedName("time")
    @Expose
    private Double time;
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    /**
     *
     * @return
     * The time
     */
    public Double getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The environment
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     *
     * @param environment
     * The environment
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     *
     * @return
     * The status
     */
    public Status getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }
    public class Status {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("description")
        @Expose
        private String description;

        /**
         *
         * @return
         * The code
         */
        public Integer getCode() {
            return code;
        }

        /**
         *
         * @param code
         * The code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         *
         * @return
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

    }

    public class Post {

        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("image")
        @Expose
        private String image;

        /**
         *
         * @return
         * The postId
         */
        public String getPostId() {
            return postId;
        }

        /**
         *
         * @param postId
         * The post_id
         */
        public void setPostId(String postId) {
            this.postId = postId;
        }

        /**
         *
         * @return
         * The image
         */
        public String getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(String image) {
            this.image = image;
        }

    }

    public class Member {

        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("image")
        @Expose
        private String image;

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The image
         */
        public String getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(String image) {
            this.image = image;
        }

    }

    public class Datum {

        @SerializedName("activity")
        @Expose
        private String activity;
        @SerializedName("time")
        @Expose
        private Integer time;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("text")
        @Expose
        private List<String> text = new ArrayList<String>();
        @SerializedName("content")
        @Expose
        private Content content;
        @SerializedName("web_redir_url")
        @Expose
        private String webRedirUrl;

        /**
         *
         * @return
         * The activity
         */
        public String getActivity() {
            return activity;
        }

        /**
         *
         * @param activity
         * The activity
         */
        public void setActivity(String activity) {
            this.activity = activity;
        }

        /**
         *
         * @return
         * The time
         */
        public Integer getTime() {
            return time;
        }

        /**
         *
         * @param time
         * The time
         */
        public void setTime(Integer time) {
            this.time = time;
        }

        /**
         *
         * @return
         * The date
         */
        public String getDate() {
            return date;
        }

        /**
         *
         * @param date
         * The date
         */
        public void setDate(String date) {
            this.date = date;
        }

        /**
         *
         * @return
         * The text
         */
        public List<String> getText() {
            return text;
        }

        /**
         *
         * @param text
         * The text
         */
        public void setText(List<String> text) {
            this.text = text;
        }

        /**
         *
         * @return
         * The content
         */
        public Content getContent() {
            return content;
        }

        /**
         *
         * @param content
         * The content
         */
        public void setContent(Content content) {
            this.content = content;
        }

        /**
         *
         * @return
         * The webRedirUrl
         */
        public String getWebRedirUrl() {
            return webRedirUrl;
        }

        /**
         *
         * @param webRedirUrl
         * The web_redir_url
         */
        public void setWebRedirUrl(String webRedirUrl) {
            this.webRedirUrl = webRedirUrl;
        }

    }

    public class Content {
        @SerializedName("receiver_id")
        @Expose
        private String receiver_id;

        public String getReceiver_id() {
            return receiver_id;
        }

        public void setReceiver_id(String receiver_id) {
            this.receiver_id = receiver_id;
        }

        public String getReceiver_username() {
            return receiver_username;
        }

        public void setReceiver_username(String receiver_username) {
            this.receiver_username = receiver_username;
        }

        public String getReceiver_image() {
            return receiver_image;
        }

        public void setReceiver_image(String receiver_image) {
            this.receiver_image = receiver_image;
        }

        @SerializedName("receiver_username")
        @Expose

        private String receiver_username;
        @SerializedName("receiver_image")
        @Expose
        private String receiver_image;

        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("like_id")
        @Expose
        private String likeId;
        @SerializedName("member")
        @Expose
        private Member member;
        @SerializedName("post")
        @Expose
        private Post post;

        /**
         *
         * @return
         * The postId
         */
        public String getPostId() {
            return postId;
        }

        /**
         *
         * @param postId
         * The post_id
         */
        public void setPostId(String postId) {
            this.postId = postId;
        }

        /**
         *
         * @return
         * The likeId
         */
        public String getLikeId() {
            return likeId;
        }

        /**
         *
         * @param likeId
         * The like_id
         */
        public void setLikeId(String likeId) {
            this.likeId = likeId;
        }

        /**
         *
         * @return
         * The member
         */
        public Member getMember() {
            return member;
        }

        /**
         *
         * @param member
         * The member
         */
        public void setMember(Member member) {
            this.member = member;
        }

        /**
         *
         * @return
         * The post
         */
        public Post getPost() {
            return post;
        }

        /**
         *
         * @param post
         * The post
         */
        public void setPost(Post post) {
            this.post = post;
        }

    }


}
