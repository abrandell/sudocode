package org.sudocode.api.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.data.annotation.AccessType;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

import static org.springframework.data.annotation.AccessType.Type;

/**
 * This class exists in the case you need to compare <b>detached or un-managed entities</b>.
 * <p>It generates the AbstractEntity, equals, and hashcode for all entities that extend it.
 *
 * <p>The hashcode is always unique, even for non-managed entities since they are created at object instantiation.
 */
@MappedSuperclass
@AccessType(Type.FIELD)
public abstract class AbstractEntity implements Serializable {

    @JsonIgnore
    @Transient
    private static final long serialVersionUID = 33L;

    @JsonIgnore
    private final String UUID = java.util.UUID.randomUUID().toString();
    ;

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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return new EqualsBuilder()
                .append(UUID, that.UUID)
                .isEquals();
    }
}
