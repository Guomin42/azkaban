/*
 * Copyright 2017 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package azkaban.execapp;

import azkaban.Constants;
import azkaban.utils.Props;
import org.json.simple.JSONObject;

class LogUtil {

  static JSONObject createLogPatternLayoutJsonObject(Props props, String jobId) {
    final JSONObject layout = new JSONObject();
    layout.put("category", "%c{1}");
    layout.put("level", "%p");
    layout.put("message", "%m");
    layout.put("projectname",
        props.getString(Constants.FlowProperties.AZKABAN_FLOW_PROJECT_NAME));
    layout.put("flowid", props.getString(Constants.FlowProperties.AZKABAN_FLOW_FLOW_ID));
    layout.put("jobid", jobId);
    layout
        .put("submituser", props.getString(Constants.FlowProperties.AZKABAN_FLOW_SUBMIT_USER));
    layout.put("execid", props.getString(Constants.FlowProperties.AZKABAN_FLOW_EXEC_ID));
    layout.put("projectversion",
        props.getString(Constants.FlowProperties.AZKABAN_FLOW_PROJECT_VERSION));
    layout.put("logsource", "userJob");
    return layout;
  }
}
