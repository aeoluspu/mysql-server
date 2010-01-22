/*
   Copyright (C) 2009 Sun Microsystems Inc.
   All rights reserved. Use is subject to license terms.

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; version 2 of the License.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301  USA
*/

package com.mysql.clusterj.core.spi;

import com.mysql.clusterj.core.query.CandidateIndexImpl;
import com.mysql.clusterj.core.query.PredicateImpl;
import com.mysql.clusterj.core.store.IndexScanOperation;
import com.mysql.clusterj.core.store.IndexScanOperation.BoundType;
import com.mysql.clusterj.core.store.Operation;
import com.mysql.clusterj.core.store.ScanFilter;
import com.mysql.clusterj.core.store.ScanFilter.BinaryCondition;

/**
 *
 */
public interface DomainFieldHandler {

    void filterCompareValue(Object value, BinaryCondition condition, ScanFilter filter);

    void markEqualBounds(CandidateIndexImpl[] candidateIndices, PredicateImpl predicate);

    void markLowerBounds(CandidateIndexImpl[] candidateIndices, PredicateImpl predicate, boolean strict);

    void markUpperBounds(CandidateIndexImpl[] candidateIndices, PredicateImpl predicate, boolean strict);

    void objectSetValueFor(Object value, Object row, String indexName);

    void operationEqual(Object value, Operation op);

    void operationEqualForIndex(Object parameterValue, Operation op, String indexName);

    void operationSetBounds(Object value, BoundType type, IndexScanOperation op);

    void operationSetValue(ValueHandler handler, Operation op);

}
