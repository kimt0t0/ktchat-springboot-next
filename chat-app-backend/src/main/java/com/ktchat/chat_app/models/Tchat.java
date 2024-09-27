package com.ktchat.chat_app.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tchats")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Tchat extends AbstractEntity {

    @Column(nullable = false)
    private String title;

    @Column
    private boolean isPrivate;

    @ManyToOne()
    @JoinColumn(name = "id_owner")
    private User owner;

    @OneToMany(mappedBy = "tchat", cascade = CascadeType.MERGE)
    private List<Message> messages;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "tchats_messages", joinColumns = @JoinColumn(name = "tchat_id"), inverseJoinColumns = @JoinColumn(name = "message_id"))
    private List<User> members;

}
