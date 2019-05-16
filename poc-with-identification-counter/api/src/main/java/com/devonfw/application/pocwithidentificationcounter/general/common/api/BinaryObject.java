package com.devonfw.application.pocwithidentificationcounter.general.common.api;

/**
 * This is the interface for a {@link BinaryObject} of the poc-with-identification-counter.
 */
public interface BinaryObject<T> extends ApplicationEntity<T> {

  /**
   * @param mimeType is the MIME-Type of this {@link BinaryObject}
   */
  void setMimeType(String mimeType);

  /**
   * Returns MIME-Type of thie {@link BinaryObject}
   *
   * @return the MIME-Type, e.g image/jpeg
   */
  String getMimeType();

  /**
   * @return Returns the size in bytes
   */
  long getSize();

  /**
   * Sets the size of bytes
   *
   * @param size the size in bytes
   */
  void setSize(long size);

}
