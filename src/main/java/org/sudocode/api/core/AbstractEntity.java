package org.sudocode.api.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static org.springframework.data.annotation.AccessType.Type;

/**
 * This class exists in the case you need to compare <b>detached or un-managed
 * entities</b>.
 * <p>
 * It generates the UUID, equals, and hashcode for all entities that extend it.
 *
 * <p>
 * The hashcode is always unique, even for non-managed entities since the UUID is created
 * at object instantiation.
 */
@MappedSuperclass
@AccessType(Type.FIELD)
public abstract class AbstractEntity implements Serializable, Persistable<Long> {

    // So the generator picks IDENTITY instead of TABLE
    // https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @JsonIgnore
    @Transient
    private static final long serialVersionUID = 33L;

    @JsonIgnore
    private final String UUID = java.util.UUID.randomUUID().toString();

    /**
     * @return The UUID in the form of a {@literal String}.
     * @serialData
     */
    protected String getUUID() {
        return this.UUID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(UUID);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AbstractEntity that = (AbstractEntity) o;

        return new EqualsBuilder().append(UUID, that.UUID).isEquals();
    }

}
