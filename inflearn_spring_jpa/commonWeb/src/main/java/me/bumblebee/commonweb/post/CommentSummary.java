package me.bumblebee.commonweb.post;

public class CommentSummary {

     private Long id;

     private int up;

     private int down;

     public CommentSummary(Long id, int up, int down) {
          this.id = id;
          this.up = up;
          this.down = down;
     }

     public Long getId() {
          return id;
     }

     public int getUp() {
          return up;
     }

     public int getDown() {
          return down;
     }

     public String getVotes() {
          return this.up + " "  + this.down;
     }
}
