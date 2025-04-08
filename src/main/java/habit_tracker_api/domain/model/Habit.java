package habit_tracker_api.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity(name = "tb_habit")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String name;

    @Schema(hidden = true)
    private Long idUser;

    @OneToMany(mappedBy="habit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @com.fasterxml.jackson.annotation.JsonManagedReference
    @Schema(hidden = true)
    private List<Historic> historicList;;

    public void setConcluido(){
        Historic historic = new Historic();
        historic.setDate(LocalDateTime.now());
        historic.setCompleted(true);
        historic.setHabit(this);

        if (this.historicList == null) {
            this.historicList = new ArrayList<>();
        }

        this.historicList.add(historic);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Historic> getHistoricList() {
        if (this.historicList == null) {
            return new ArrayList<>();
        }
        return historicList;
    }

    public void setHistoricList(List<Historic> historicList) {
        this.historicList = historicList;
    }
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }


}