/**
 * Autogenerated by Thrift Compiler (0.14.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.pja.sri.lab06;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.1)", date = "2021-06-16")
public class Book implements org.apache.thrift.TBase<Book, Book._Fields>, java.io.Serializable, Cloneable, Comparable<Book> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Book");

  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField AUTHOR_FIELD_DESC = new org.apache.thrift.protocol.TField("author", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField GENRE_FIELD_DESC = new org.apache.thrift.protocol.TField("genre", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PUBLICATION_YEAR_FIELD_DESC = new org.apache.thrift.protocol.TField("publicationYear", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("price", org.apache.thrift.protocol.TType.DOUBLE, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BookStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BookTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String title; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String author; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String genre; // required
  public int publicationYear; // required
  public double price; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TITLE((short)1, "title"),
    AUTHOR((short)2, "author"),
    GENRE((short)3, "genre"),
    PUBLICATION_YEAR((short)4, "publicationYear"),
    PRICE((short)5, "price");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TITLE
          return TITLE;
        case 2: // AUTHOR
          return AUTHOR;
        case 3: // GENRE
          return GENRE;
        case 4: // PUBLICATION_YEAR
          return PUBLICATION_YEAR;
        case 5: // PRICE
          return PRICE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PUBLICATIONYEAR_ISSET_ID = 0;
  private static final int __PRICE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AUTHOR, new org.apache.thrift.meta_data.FieldMetaData("author", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GENRE, new org.apache.thrift.meta_data.FieldMetaData("genre", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PUBLICATION_YEAR, new org.apache.thrift.meta_data.FieldMetaData("publicationYear", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PRICE, new org.apache.thrift.meta_data.FieldMetaData("price", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Book.class, metaDataMap);
  }

  public Book() {
  }

  public Book(
    java.lang.String title,
    java.lang.String author,
    java.lang.String genre,
    int publicationYear,
    double price)
  {
    this();
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publicationYear = publicationYear;
    setPublicationYearIsSet(true);
    this.price = price;
    setPriceIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Book(Book other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetAuthor()) {
      this.author = other.author;
    }
    if (other.isSetGenre()) {
      this.genre = other.genre;
    }
    this.publicationYear = other.publicationYear;
    this.price = other.price;
  }

  public Book deepCopy() {
    return new Book(this);
  }

  @Override
  public void clear() {
    this.title = null;
    this.author = null;
    this.genre = null;
    setPublicationYearIsSet(false);
    this.publicationYear = 0;
    setPriceIsSet(false);
    this.price = 0.0;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getTitle() {
    return this.title;
  }

  public Book setTitle(@org.apache.thrift.annotation.Nullable java.lang.String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getAuthor() {
    return this.author;
  }

  public Book setAuthor(@org.apache.thrift.annotation.Nullable java.lang.String author) {
    this.author = author;
    return this;
  }

  public void unsetAuthor() {
    this.author = null;
  }

  /** Returns true if field author is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthor() {
    return this.author != null;
  }

  public void setAuthorIsSet(boolean value) {
    if (!value) {
      this.author = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getGenre() {
    return this.genre;
  }

  public Book setGenre(@org.apache.thrift.annotation.Nullable java.lang.String genre) {
    this.genre = genre;
    return this;
  }

  public void unsetGenre() {
    this.genre = null;
  }

  /** Returns true if field genre is set (has been assigned a value) and false otherwise */
  public boolean isSetGenre() {
    return this.genre != null;
  }

  public void setGenreIsSet(boolean value) {
    if (!value) {
      this.genre = null;
    }
  }

  public int getPublicationYear() {
    return this.publicationYear;
  }

  public Book setPublicationYear(int publicationYear) {
    this.publicationYear = publicationYear;
    setPublicationYearIsSet(true);
    return this;
  }

  public void unsetPublicationYear() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PUBLICATIONYEAR_ISSET_ID);
  }

  /** Returns true if field publicationYear is set (has been assigned a value) and false otherwise */
  public boolean isSetPublicationYear() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PUBLICATIONYEAR_ISSET_ID);
  }

  public void setPublicationYearIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PUBLICATIONYEAR_ISSET_ID, value);
  }

  public double getPrice() {
    return this.price;
  }

  public Book setPrice(double price) {
    this.price = price;
    setPriceIsSet(true);
    return this;
  }

  public void unsetPrice() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PRICE_ISSET_ID);
  }

  /** Returns true if field price is set (has been assigned a value) and false otherwise */
  public boolean isSetPrice() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PRICE_ISSET_ID);
  }

  public void setPriceIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PRICE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((java.lang.String)value);
      }
      break;

    case AUTHOR:
      if (value == null) {
        unsetAuthor();
      } else {
        setAuthor((java.lang.String)value);
      }
      break;

    case GENRE:
      if (value == null) {
        unsetGenre();
      } else {
        setGenre((java.lang.String)value);
      }
      break;

    case PUBLICATION_YEAR:
      if (value == null) {
        unsetPublicationYear();
      } else {
        setPublicationYear((java.lang.Integer)value);
      }
      break;

    case PRICE:
      if (value == null) {
        unsetPrice();
      } else {
        setPrice((java.lang.Double)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TITLE:
      return getTitle();

    case AUTHOR:
      return getAuthor();

    case GENRE:
      return getGenre();

    case PUBLICATION_YEAR:
      return getPublicationYear();

    case PRICE:
      return getPrice();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TITLE:
      return isSetTitle();
    case AUTHOR:
      return isSetAuthor();
    case GENRE:
      return isSetGenre();
    case PUBLICATION_YEAR:
      return isSetPublicationYear();
    case PRICE:
      return isSetPrice();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof Book)
      return this.equals((Book)that);
    return false;
  }

  public boolean equals(Book that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_author = true && this.isSetAuthor();
    boolean that_present_author = true && that.isSetAuthor();
    if (this_present_author || that_present_author) {
      if (!(this_present_author && that_present_author))
        return false;
      if (!this.author.equals(that.author))
        return false;
    }

    boolean this_present_genre = true && this.isSetGenre();
    boolean that_present_genre = true && that.isSetGenre();
    if (this_present_genre || that_present_genre) {
      if (!(this_present_genre && that_present_genre))
        return false;
      if (!this.genre.equals(that.genre))
        return false;
    }

    boolean this_present_publicationYear = true;
    boolean that_present_publicationYear = true;
    if (this_present_publicationYear || that_present_publicationYear) {
      if (!(this_present_publicationYear && that_present_publicationYear))
        return false;
      if (this.publicationYear != that.publicationYear)
        return false;
    }

    boolean this_present_price = true;
    boolean that_present_price = true;
    if (this_present_price || that_present_price) {
      if (!(this_present_price && that_present_price))
        return false;
      if (this.price != that.price)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTitle()) ? 131071 : 524287);
    if (isSetTitle())
      hashCode = hashCode * 8191 + title.hashCode();

    hashCode = hashCode * 8191 + ((isSetAuthor()) ? 131071 : 524287);
    if (isSetAuthor())
      hashCode = hashCode * 8191 + author.hashCode();

    hashCode = hashCode * 8191 + ((isSetGenre()) ? 131071 : 524287);
    if (isSetGenre())
      hashCode = hashCode * 8191 + genre.hashCode();

    hashCode = hashCode * 8191 + publicationYear;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(price);

    return hashCode;
  }

  @Override
  public int compareTo(Book other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetTitle(), other.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, other.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAuthor(), other.isSetAuthor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.author, other.author);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetGenre(), other.isSetGenre());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGenre()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.genre, other.genre);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPublicationYear(), other.isSetPublicationYear());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPublicationYear()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.publicationYear, other.publicationYear);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPrice(), other.isSetPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.price, other.price);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Book(");
    boolean first = true;

    sb.append("title:");
    if (this.title == null) {
      sb.append("null");
    } else {
      sb.append(this.title);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("author:");
    if (this.author == null) {
      sb.append("null");
    } else {
      sb.append(this.author);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("genre:");
    if (this.genre == null) {
      sb.append("null");
    } else {
      sb.append(this.genre);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("publicationYear:");
    sb.append(this.publicationYear);
    first = false;
    if (!first) sb.append(", ");
    sb.append("price:");
    sb.append(this.price);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (title == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'title' was not present! Struct: " + toString());
    }
    if (author == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'author' was not present! Struct: " + toString());
    }
    if (genre == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'genre' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'publicationYear' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'price' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BookStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BookStandardScheme getScheme() {
      return new BookStandardScheme();
    }
  }

  private static class BookStandardScheme extends org.apache.thrift.scheme.StandardScheme<Book> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Book struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.title = iprot.readString();
              struct.setTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // AUTHOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.author = iprot.readString();
              struct.setAuthorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // GENRE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.genre = iprot.readString();
              struct.setGenreIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PUBLICATION_YEAR
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.publicationYear = iprot.readI32();
              struct.setPublicationYearIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PRICE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.price = iprot.readDouble();
              struct.setPriceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetPublicationYear()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'publicationYear' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetPrice()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'price' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Book struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.title != null) {
        oprot.writeFieldBegin(TITLE_FIELD_DESC);
        oprot.writeString(struct.title);
        oprot.writeFieldEnd();
      }
      if (struct.author != null) {
        oprot.writeFieldBegin(AUTHOR_FIELD_DESC);
        oprot.writeString(struct.author);
        oprot.writeFieldEnd();
      }
      if (struct.genre != null) {
        oprot.writeFieldBegin(GENRE_FIELD_DESC);
        oprot.writeString(struct.genre);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PUBLICATION_YEAR_FIELD_DESC);
      oprot.writeI32(struct.publicationYear);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PRICE_FIELD_DESC);
      oprot.writeDouble(struct.price);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BookTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BookTupleScheme getScheme() {
      return new BookTupleScheme();
    }
  }

  private static class BookTupleScheme extends org.apache.thrift.scheme.TupleScheme<Book> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Book struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.title);
      oprot.writeString(struct.author);
      oprot.writeString(struct.genre);
      oprot.writeI32(struct.publicationYear);
      oprot.writeDouble(struct.price);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Book struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.title = iprot.readString();
      struct.setTitleIsSet(true);
      struct.author = iprot.readString();
      struct.setAuthorIsSet(true);
      struct.genre = iprot.readString();
      struct.setGenreIsSet(true);
      struct.publicationYear = iprot.readI32();
      struct.setPublicationYearIsSet(true);
      struct.price = iprot.readDouble();
      struct.setPriceIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
