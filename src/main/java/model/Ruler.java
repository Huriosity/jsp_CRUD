package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "ruler")
public class Ruler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "year_of_birth")
    private Integer year_of_birth;

    @Column(name = "year_of_death")
    private Integer year_of_death;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "testator", referencedColumnName = "id")
    private Ruler testator;

    public Ruler getTestator() {
        return testator;
    }

    public void setTestator(Ruler testator) {
        this.testator = testator;
    }

    //OneToMany Example
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testator",fetch = FetchType.EAGER)///////////////////////////////////////
    // @ElementCollection(targetClass=Ruler.class)/////////////////
    private Set<Ruler> rulerHeirs = new HashSet<Ruler>();

    public Set<Ruler> getRullerHeirs() {
        return rulerHeirs;
    }

    public void setRullerHeirs(Set<Ruler> rulerHeirs) {
        this.rulerHeirs = rulerHeirs;
    }

    public void addRulerHeir(Ruler contact) {
        contact.setTestator(this);
        this.rulerHeirs.add(contact);
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "ruller_id") //////////////////////////////////////////////////
    private RullerMainTitleRel rullerMainTitleRel;

    public RullerMainTitleRel getRullerMainTitleRel() {
        return this.rullerMainTitleRel;
    }

    public void setRullerMainTitleRel(RullerMainTitleRel rullerMainTitleRel) {
        this.rullerMainTitleRel = rullerMainTitleRel;
    }

    /////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /////////////////////////////////////////////////////////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /////////////////////////////////////////////////////////
    public Integer getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(Integer year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    /////////////////////////////////////////////////////////
    public Integer getYear_of_death() {
        return year_of_death;
    }

    public void setYear_of_death(Integer year_of_death) {
        this.year_of_death = year_of_death;
    }

    /////////////////////////////////////////////////////////

    public Ruler(){

    };

    @Override
    public String toString() {
        if (testator != null) {
            return "Ruler:\n" +
                    "id: " + id +
                    "\nName: " + name + "\n" +
                    "year of birth: " + year_of_birth + "\n" +
                    "year if death: " + year_of_death + "\n" +
                    "testator id : " + testator.getId() + "\n" +
                    "testator name : " + testator.getName() + "\n" ;

        }
        return "Ruler:\n" +
                "id: " + id +
                "\nName: " + name + "\n" +
                "year of birth: " + year_of_birth + "\n" +
                "year if death: " + year_of_death + "\n" +
                "testator : " + testator + "\n";
    }
}
