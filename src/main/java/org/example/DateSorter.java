package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

  public static void main(String[] args) {
    DateSorter dateSorter = new DateSorter();
    List<LocalDate> list = List.of(LocalDate.parse("2004-07-01"),
        LocalDate.parse("2005-01-02"),LocalDate.parse("2007-01-01"),LocalDate.parse("2032-05-03"));
    Collection<LocalDate> result = dateSorter.sortDates(list);
    System.out.println(result);
  }

  /**
   * The implementation of this method should sort dates.
   * The output should be in the following order:
   * Dates with an 'r' in the month,
   * sorted ascending (first to last),
   * then dates without an 'r' in the month,
   * sorted descending (last to first).
   * For example, October dates would come before May dates,
   * because October has an 'r' in it.
   * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
   * would sort to
   * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
   *
   * @param unsortedDates - an unsorted list of dates
   * @return the collection of dates now sorted as per the spec
   */
  public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
    List listNumberMonthWithRLetter = List.of(1,2,3,4,9,10,11,12);
    List<LocalDate> listDateMonthWithR = unsortedDates.stream().filter(n->listNumberMonthWithRLetter.contains(n.getMonthValue()))
        .sorted().collect(Collectors.toList());
    List<LocalDate> listDateMonthWithoutR = unsortedDates.stream().filter(n->!listNumberMonthWithRLetter.contains(n.getMonthValue()))
        .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    //System.out.println(listDateMonthWithR);
    //System.out.println(listDateMonthWithoutR);
    return Stream.concat(listDateMonthWithR.stream(),listDateMonthWithoutR.stream()).toList();

  }
}