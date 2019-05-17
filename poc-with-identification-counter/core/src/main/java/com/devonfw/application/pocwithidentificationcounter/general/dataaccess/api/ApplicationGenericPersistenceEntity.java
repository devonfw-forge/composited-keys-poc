package com.devonfw.application.pocwithidentificationcounter.general.dataaccess.api;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.devonfw.application.pocwithidentificationcounter.general.common.api.ApplicationGenericEntity;
import com.devonfw.module.basic.common.api.entity.PersistenceEntity;

@MappedSuperclass
public abstract class ApplicationGenericPersistenceEntity<T> implements ApplicationGenericEntity<T>, PersistenceEntity<T> {

  private static final long serialVersionUID = 1L;

  private T id;

  private int modificationCounter;

  /**
   * The constructor.
   */
  public ApplicationGenericPersistenceEntity() {

    super();
  }

  @Override
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public T getId() {

    return this.id;
  }

  @Override
  public void setId(T id) {

    this.id = id;
  }

  @Override
  @Version
  public int getModificationCounter() {

    return this.modificationCounter;
  }

  @Override
  public void setModificationCounter(int version) {

    this.modificationCounter = version;
  }

  @Override
  public String toString() {

    StringBuilder buffer = new StringBuilder();
    toString(buffer);
    return buffer.toString();
  }

  /**
   * Method to extend {@link #toString()} logic.
   *
   * @param buffer is the {@link StringBuilder} where to {@link StringBuilder#append(Object) append} the string
   *        representation.
   */
  protected void toString(StringBuilder buffer) {

    buffer.append(getClass().getSimpleName());
    if (this.id != null) {
      buffer.append("[id=");
      buffer.append(this.id);
      buffer.append("]");
    }
  }
}