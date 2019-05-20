package hello;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private static long counter = 0;

    private long id;
    private String content;
    private Date createTime;

    public Task(){
        this.id = Task.counter++;
        this.content = "";
        this.createTime = new Date();
    }

    public Task(String content) {
        this.id = Task.counter++;
        this.content = content;
        this.createTime = new Date();
    }


    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return dateFormat.format(createTime);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}