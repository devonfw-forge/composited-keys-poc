package com.devonfw.application.pocwithidentificationcounter.general.logic.api.to;

import com.devonfw.application.pocwithidentificationcounter.general.common.api.BinaryObject;
import com.devonfw.application.pocwithidentificationcounter.general.common.api.to.AbstractGenericEto;

/**
 * The {@link com.devonfw.module.basic.common.api.to.AbstractEto ETO} for a {@link BinaryObject}.
 */
public class BinaryObjectEto<T> extends AbstractGenericEto<T> implements BinaryObject<T> {

  private static final long serialVersionUID = 1L;

  private String mimeType;

  private long size;

  /**
   * Constructor.
   */
  public BinaryObjectEto() {

    super();
  }

  @Override
  public void setMimeType(String mimeType) {

    this.mimeType = mimeType;

  }

  @Override
  public String getMimeType() {

    return this.mimeType;
  }

  @Override
  public long getSize() {

    return this.size;
  }

  @Override
  public void setSize(long size) {

    this.size = size;
  }

}
