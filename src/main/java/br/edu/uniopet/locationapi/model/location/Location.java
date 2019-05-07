package br.edu.uniopet.locationapi.model.location;

import br.edu.uniopet.locationapi.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @Column(name = "CITY")
    private String city;

    @NonNull
    @Column(name = "STATE")
    private String state;

    @NonNull
    @Column(name = "URL")
    private String url;

    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "ID_ACCOUNT", foreignKey = @ForeignKey(name = "FK_ID_ACCOUNT"))
    private Account account;
}
