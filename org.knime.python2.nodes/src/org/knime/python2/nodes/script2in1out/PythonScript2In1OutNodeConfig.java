/*
 * ------------------------------------------------------------------------
 *  Copyright by KNIME AG, Zurich, Switzerland
 *  Website: http://www.knime.com; Email: contact@knime.com
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License, Version 3, as
 *  published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 *  Additional permission under GNU GPL version 3 section 7:
 *
 *  KNIME interoperates with ECLIPSE solely via ECLIPSE's plug-in APIs.
 *  Hence, KNIME and ECLIPSE are both independent programs and are not
 *  derived from each other. Should, however, the interpretation of the
 *  GNU GPL Version 3 ("License") under any applicable laws result in
 *  KNIME and ECLIPSE being a combined program, KNIME AG herewith grants
 *  you the additional permission to use and propagate KNIME together with
 *  ECLIPSE with only the license terms in place for ECLIPSE applying to
 *  ECLIPSE and the GNU GPL Version 3 applying for KNIME, provided the
 *  license terms of ECLIPSE themselves allow for the respective use and
 *  propagation of ECLIPSE together with KNIME.
 *
 *  Additional permission relating to nodes for KNIME that extend the Node
 *  Extension (and in particular that are based on subclasses of NodeModel,
 *  NodeDialog, and NodeView) and that only interoperate with KNIME through
 *  standard APIs ("Nodes"):
 *  Nodes are deemed to be separate and independent programs and to not be
 *  covered works.  Notwithstanding anything to the contrary in the
 *  License, the License does not apply to Nodes, you are not required to
 *  license Nodes under the License, and you are granted a license to
 *  prepare and propagate Nodes, in each case even if such Nodes are
 *  propagated with or for interoperation with KNIME.  The owner of a Node
 *  may freely choose the license terms applicable to such Node, including
 *  when such Node is propagated with or for interoperation with KNIME.
 * ------------------------------------------------------------------------
 *
 * History
 *   Sep 25, 2014 (Patrick Winter): created
 */
package org.knime.python2.nodes.script2in1out;

import org.knime.python2.config.PythonSourceCodeConfig;
import org.knime.python2.generic.VariableNames;
import org.knime.python2.nodes.script2.Python2ScriptNodeFactory2;
import org.knime.python2.ports.DataTableInputPort;
import org.knime.python2.ports.InputPort;

/**
 * @deprecated Replaced by {@link Python2ScriptNodeFactory2} and its components.
 *
 * @author Patrick Winter, KNIME AG, Zurich, Switzerland
 * @author Marcel Wiedenmann, KNIME GmbH, Konstanz, Germany
 */
@Deprecated
final class PythonScript2In1OutNodeConfig extends PythonSourceCodeConfig {

    private static final String INPUT_TABLE_1_NAME = "input_table_1";

    private static final String INPUT_TABLE_2_NAME = "input_table_2";

    private static final VariableNames VARIABLE_NAMES = new VariableNames("flow_variables",
        new String[]{INPUT_TABLE_1_NAME, INPUT_TABLE_2_NAME}, new String[]{"output_table"}, null, null, null);

    public static InputPort[] getInputPorts() {
        return new InputPort[]{new DataTableInputPort(INPUT_TABLE_1_NAME), new DataTableInputPort(INPUT_TABLE_2_NAME)};
    }

    public static VariableNames getVariableNames() {
        return VARIABLE_NAMES;
    }

    @Override
    protected String getDefaultSourceCode() {
        return "# Do pandas inner join\n" + VARIABLE_NAMES.getOutputTables()[0] + " = "
            + VARIABLE_NAMES.getInputTables()[0] + ".join(" + VARIABLE_NAMES.getInputTables()[1]
            + ", how='inner', lsuffix=' (left)', rsuffix=' (right)')\n";
    }
}
