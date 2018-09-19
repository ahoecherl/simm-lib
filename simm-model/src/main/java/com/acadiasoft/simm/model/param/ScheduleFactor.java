package com.acadiasoft.simm.model.param;

import com.acadiasoft.simm.model.object.imtree.identifiers.RiskClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.SensitivityClass;
import com.acadiasoft.simm.model.object.imtree.identifiers.WeightingClass;
import com.acadiasoft.simm.model.param.cnq.CreditNonQualifyingRiskWeightV2_0;
import com.acadiasoft.simm.model.param.commodity.CommodityRiskWeightV2_0;
import com.acadiasoft.simm.model.param.cq.CreditQualifyingRiskWeightV2_0;
import com.acadiasoft.simm.model.param.equity.EquityRiskWeightV2_0;
import com.acadiasoft.simm.model.param.fx.FXRiskWeightV2_0;
import com.acadiasoft.simm.model.param.interestrate.InterestRateRiskWeightV2_0;

import java.math.BigDecimal;

public interface ScheduleFactor {

  public static BigDecimal get(SensitivityClass s, WeightingClass weightingClass) {
    return new BigDecimal("0");
  }

}
