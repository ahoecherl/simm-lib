/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acadiasoft.simm.model.object.imtree.identifiers;

import com.acadiasoft.simm.model.object.imtree.MarginIdentifier;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * As defined in Appendix 1 section K of doc/ISDA_SIMM_2.0_(PUBLIC).pdf
 */
public enum ScheduleAssetClass implements MarginIdentifier {

  FX("FX", "Foreign Exchange"), //
  EQUITY("Equity", "Equity"), //
  COMMODITY("Commodity", "Commodity"), //
  CREDITSUB2Y("Credity_<2y", "Credit below 2 years maturity"), //
  CREDIT2YTO5Y("Credity_2y-5y", "Credit between two and five years maturity"), //
  CREDITABOVE5Y("Credit_>5y", "Credit above five years maturity"); //

  private static final List<ScheduleAssetClass> ALL = Arrays.asList(values());

  private final String label;
  private final String description;

  private ScheduleAssetClass(String label, String description){
    this.label = label;
    this.description = description;
  }

  @Override
  public String getLabel() { return label; }

  public static int indexOf(String scheduleAssetClass) { return 0; }

}
